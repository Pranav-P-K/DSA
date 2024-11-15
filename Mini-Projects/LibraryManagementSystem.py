import mysql.connector

# Connecting to MySQL
mydb = mysql.connector.connect(
    host="localhost",
    user="yourUserName", # default: root
    passwd="yourPassword"
)
mycursor = mydb.cursor()

# Creating database and tables
mycursor.execute("CREATE DATABASE IF NOT EXISTS store")
mycursor.execute("USE store")
mycursor.execute("""
    CREATE TABLE IF NOT EXISTS signup (
        username VARCHAR(20),
        passwd VARCHAR(20)
    )
""")

while True:
    print("1: Signup\n2: Login")
    ch = int(input("SIGNUP/LOGIN (1, 2): "))

    # Signup
    if ch == 1:
        username = input("USERNAME: ")
        pw = input("PASSWORD: ")
        mycursor.execute(
            "INSERT INTO signup VALUES ('{}', '{}')".format(username, pw)
        )
        mydb.commit()

    # Login
    elif ch == 2:
        username = input("USERNAME: ")
        mycursor.execute(
            "SELECT username FROM signup WHERE username = '{}'".format(username)
        )
        pot = mycursor.fetchone()
        
        if pot:
            print("VALID USERNAME!")
            pw = input("PASSWORD: ")
            mycursor.execute(
                "SELECT passwd FROM signup WHERE passwd = '{}'".format(pw)
            )
            a = mycursor.fetchone()
            
            if a:
                print("++++++++++++ LOGIN SUCCESSFUL ++++++++++++")
                break

while True:
    print("===== PK BOOK STALL =====")
    mycursor.execute("""
        CREATE TABLE IF NOT EXISTS Available_Books (
            BookName VARCHAR(750) PRIMARY KEY,
            Genre VARCHAR(20),
            Quantity INT(3),
            Author VARCHAR(750),
            Publication VARCHAR(750),
            Price INT(4)
        )
    """)
    mycursor.execute("""
        CREATE TABLE IF NOT EXISTS Sell_rec (
            CustomerName VARCHAR(20),
            PhoneNumber CHAR(10) UNIQUE,
            BookName VARCHAR(750),
            Quantity INT(100),
            Price INT(4),
            FOREIGN KEY(BookName) REFERENCES Available_Books(BookName)
        )
    """)
    mycursor.execute("""
        CREATE TABLE IF NOT EXISTS Staff_details (
            Name VARCHAR(30),
            Gender VARCHAR(10),
            Age INT(3),
            PhoneNumber CHAR(10) UNIQUE,
            Address VARCHAR(40)
        )
    """)
    mydb.commit()

    print("""
        1: Add Books  
        2: Delete Books 
        3: Search Books 
        4: Staff Details 
        5: Sell Record 
        6: Available Books 
        7: Total Income after the latest Reset 
        8: Exit
    """)
    
    a = int(input("Enter your choice: "))

    # Add Books
    if a == 1:
        print("All information prompted are mandatory to be filled")
        book = input("Enter Book Name: ")
        genre = input("Genre: ")
        quantity = int(input("Enter quantity: "))
        author = input("Enter author Name: ")
        publication = input("Enter Publication house: ")
        price = int(input("Enter the price: "))
        
        mycursor.execute(
            "SELECT * FROM Available_Books WHERE BookName = '{}'".format(book)
        )
        row = mycursor.fetchone()
        
        if row:
            mycursor.execute(
                "UPDATE Available_Books SET quantity = quantity + '{}' WHERE BookName = '{}'".format(quantity, book)
            )
        else:
            mycursor.execute(
                "INSERT INTO Available_Books (BookName, Genre, Quantity, Author, Publication, Price) VALUES ('{}', '{}', '{}', '{}', '{}', '{}')".format(
                    book, genre, quantity, author, publication, price)
            )
        mydb.commit()
        print("++++++++++++ SUCCESSFULLY ADDED ++++++++++++")

    # Delete Books
    elif a == 2:
        print("AVAILABLE BOOKS...")
        mycursor.execute("SELECT * FROM Available_Books")
        for x in mycursor:
            print(x)
        cusname = input("Enter customer name: ")
        phno = int(input("Enter phone number: "))
        book = input("Enter Book Name: ")
        price = int(input("Enter the price: "))
        n = int(input("Enter quantity: "))
        
        mycursor.execute(
            "SELECT Quantity FROM Available_Books WHERE BookName = '{}'".format(book)
        )
        Ik = mycursor.fetchone()
        
        if Ik and Ik[0] >= n:
            mycursor.execute(
                "INSERT INTO Sell_rec VALUES ('{}', '{}', '{}', '{}', '{}')".format(
                    cusname, phno, book, n, price)
            )
            mycursor.execute(
                "UPDATE Available_Books SET quantity = quantity - '{}' WHERE BookName = '{}'".format(n, book)
            )
            mydb.commit()
            print("+++++++++++++ BOOK HAS BEEN SOLD +++++++++++++")
        else:
            print("BOOK IS NOT AVAILABLE!!!!!")

    # Search Books
    elif a == 3:
        print("1: Search by name\n2: Search by genre\n3: Search by author")
        I = int(input("Search by?: "))

        # By Book Name
        if I == 1:
            o = input("Enter Book to search: ")
            mycursor.execute(
                "SELECT BookName FROM Available_Books WHERE BookName = '{}'".format(o)
            )
            tree = mycursor.fetchone()
            
            if tree:
                print("++++++++++++ BOOK IS IN STOCK ++++++++++++")
            else:
                print("BOOK IS NOT IN STOCK!")

        # By Genre
        elif I == 2:
            g = input("Enter genre to search: ")
            mycursor.execute(
                "SELECT BookName FROM Available_Books WHERE Genre = '{}'".format(g)
            )
            poll = mycursor.fetchone()
            
            if poll:
                print("++++++++++++ BOOK IS IN STOCK ++++++++++++")
            else:
                print("BOOKS OF SUCH GENRE ARE NOT AVAILABLE!")

        # By Author Name
        elif I == 3:
            au = input("Enter author to search: ")
            mycursor.execute(
                "SELECT * FROM Available_Books WHERE Author = '{}'".format(au)
            )
            home = mycursor.fetchall()
            
            if home:
                print("++++++++++++ BOOK IS IN STOCK ++++++++++++")
                for z in home:
                    print(z)
            else:
                print("BOOK OF THIS AUTHOR IS NOT AVAILABLE!")
    
    # Staff Details
    elif a == 4:
        print("1: New staff entry\n2: Remove staff\n3: Existing staff details")
        ch = int(input("Enter your choice: "))

        # New Staff Entry
        if ch == 1:
            fname = input("Enter Fullname: ")
            gender = input("Gender (M/F/O): ")
            age = int(input("Age: "))
            phno = int(input("Staff phone no: "))
            add = input("Address: ")
            mycursor.execute(
                "INSERT INTO Staff_details (Name, Gender, Age, PhoneNumber, Address) VALUES ('{}', '{}', '{}', '{}', '{}')".format(
                    fname, gender, age, phno, add)
            )
            print("++++++++++++ STAFF IS SUCCESSFULLY ADDED ++++++++++++")
            mydb.commit()

        # Remove Staff
        elif ch == 2:
            nm = input("Enter staff name to remove: ")
            mycursor.execute(
                "DELETE FROM Staff_details WHERE Name = '{}'".format(nm)
            )
            mydb.commit()
            print("++++++++++++ STAFF IS SUCCESSFULLY REMOVED ++++++++++++")

        # Existing Staff Details
        elif ch == 3:
            mycursor.execute("SELECT * FROM Staff_details")
            run = mycursor.fetchall()
            
            if run:
                print("EXISTING STAFF DETAILS:")
                for t in run:
                    print(t)
            else:
                print("NO STAFF EXISTS!")
            mydb.commit()

    # Sell History
    elif a == 5:
        print("1: Sell history details\n2: Reset Sell history")
        ty = int(input("Enter your choice: "))

        # Sell History Details
        if ty == 1:
            mycursor.execute("SELECT * FROM Sell_rec")
            for u in mycursor:
                print(u)

        # Reset Sell History
        elif ty == 2:
            bb = input("Are you sure (Y/N): ")
            if bb.upper() == "Y":
                mycursor.execute("DELETE FROM Sell_rec")
                mydb.commit()

    # Available Books
    elif a == 6:
        mycursor.execute("SELECT * FROM Available_Books ORDER BY BookName")
        for v in mycursor:
            print(v)

    # Total Income After Latest Reset
    elif a == 7:
        mycursor.execute("SELECT SUM(Price) FROM Sell_rec")
        total_income = mycursor.fetchone()
        print("Total Income:", total_income[0])

    # Exit
    elif a == 8:
        break
