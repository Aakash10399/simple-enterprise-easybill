from flask import Flask, render_template, request
import pyodbc
app = Flask(__name__)
@app.route('/')
def index():
	try:
		id_arg = request.args.get('id',type=str)
		mobile = request.args.get('mobile',type=str)
		server = ''
		database = ''
		username = ''
		password = ''
		driver= '{ODBC Driver 13 for SQL Server}'
		cnxn = pyodbc.connect('DRIVER='+driver+';PORT=1433;SERVER='+server+';PORT=1443;DATABASE='+database+';UID='+username+';PWD='+ password)
		cursor = cnxn.cursor()
		cursor.execute("SELECT * FROM billTable WHERE id="+id_arg)
		row = cursor.fetchone()
		GSTIN = str(row[1])
		products = row[2].split(";")
		sgst = row[3].split(";")
		cgst = row[4].split(";")
		price = row[5].split(";")
		quantity = row[6].split(";")
		mobile_sql = str(row[7])
		prod_f = []
		price_f = []
		cgst_f = []
		sgst_f = []
		quantity_f = []
		final_price = 0.0
		if mobile==mobile_sql:
			for i in range(0,len(quantity)):
				if float(quantity[i])!=0:
					prod_f.append(products[i])
					cgst_f.append(cgst[i])
					sgst_f.append(sgst[i])
					temp = float(price[i]) + ((float(cgst[i])/100.0)*float(price[i])) + ((float(sgst[i])/100.0)*float(price[i]))
					price_f.append(temp*float(quantity[i]))
					quantity_f.append(quantity[i])
					final_price = final_price + (temp*float(quantity[i]))
			return render_template("index.html",final_price=final_price,len=len(prod_f),GSTIN=GSTIN,prod_f=prod_f,cgst_f=cgst_f,sgst_f=sgst_f,price_f=price_f,quantity_f=quantity_f)
		else:
			return "error"
	except Exception as e:
		return str(e)
if __name__ == '__main__':
  app.run()
