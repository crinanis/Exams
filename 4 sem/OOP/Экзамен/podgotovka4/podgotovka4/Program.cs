using System;

namespace podgotovka4

{
    public static class ExtenMeth
    {
        public static int MyMeth(this string email)
        {
            Console.WriteLine("11");
            return 0;
        }
    }
    class Program
    {

        public class User : IComparable
        {
            private string email;
            private string password;
            enum status
            {
                signin,
                signout
            }

            public User(string email, string password)
            {
                this.email = email;
                this.password = password;
            }

            public override string ToString()
            {
                return $"Your email: {email}";

            }
            public override int GetHashCode()
            {
                return email.GetHashCode();
            }

            public override bool Equals(object obj)
            {
                return base.Equals(obj);

            }

            public int CompareTo(object obj)
            {

                User user1 = (User)obj;

                if (this.email == user1.email)
                    return 0;
                if (this.email.Length > user1.email.Length)
                    return 1;

                else
                    return -1;
                
            }

            User pers1 = new User("lalala", "123456");
            User pers2 = new User("imSecond", "222222");


        }
        
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            string email = "";
            email.MyMeth();
        }
    }
}
