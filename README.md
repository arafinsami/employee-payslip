1. I have used OpenJDK-17
2. I have used NetFlix Discovery Server and Spring Cloud API gateway
3. To see Discovery Server, you can browse http://localhost:8761/
4. Here I have used Open API, so to see the employee payslip API, just hit with API Gateway 
   as http://localhost:9999/employee-api/swagger-ui/index.html
5. I have used Eclipse and Eclipse version is : Eclipse 2022-03 (4.23)

6. To send API request through culr as :
    curl -X 'POST' \
  'http://localhost:9999/employee-api/employee/payslip' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "employees": [
    {
      "firstName": "David",
      "lastName": "Rudd",
      "annualSalary": 60050,
      "superRate": 0.09,
      "paymentMonth": "1"
    },
    {
      "firstName": "Ryan",
      "lastName": "Chen",
      "annualSalary": 120000,
      "superRate": 0.1,
      "paymentMonth": "1"
    }
  ]
}' 
    
    Request Body :
    {
        "employees": [
            {
                "firstName": "David",
                "lastName": "Rudd",
                "annualSalary": 60050,
                "superRate": 0.09,
                "paymentMonth": "1"
            },
            {
                "firstName": "Ryan",
                "lastName": "Chen",
                "annualSalary": 120000,
                "superRate": 0.1,
                "paymentMonth": "1"
            }
        ]
    }
    

    Response Body: 
    {
        "data": [
            {
                "employee": {
                    "firstName": "David",
                    "lastName": "Rudd",
                    "annualSalary": 60050,
                    "superRate": 0.09,
                    "paymentMonth": "01 March - 31 March"
                },
                "fromDate": "01 March",
                "toDate": "31 March",
                "grossIncome": 5004,
                "incomeTax": 922,
                "superannuation": 450,
                "netIncome": 4082
            },
            {
                "employee": {
                    "firstName": "Ryan",
                    "lastName": "Chen",
                    "annualSalary": 120000,
                    "superRate": 0.1,
                    "paymentMonth": "01 March - 31 March"
                },
                "fromDate": "01 March",
                "toDate": "31 March",
                "grossIncome": 10000,
                "incomeTax": 2669,
                "superannuation": 1000,
                "netIncome": 7331
            }
        ],
        "message": "employee payslip found with given info",
        "errors": null,
        "status": "success"
    }



