using System;

namespace podgotovka2
{
    class Program
    {

        public class CreditCard
        {
            private int balance = 2000;
            private int number = 0;
            readonly int pin = 1221;
            readonly int pin2 = 4444;
            public bool flag = false;
            //public void CheckBal()
            //{
            //    int pin3;
            //    for (int i = 0; i < 3; i++)
            //    {
            //        pin3 = Convert.ToInt32(Console.ReadLine());
            //        if (pin3 == pin)
            //            break;
            //        else 

            //    }
            //}

            public void CheckBal1()
            {
                int pin3;
                int i = 1;
                do
                {
                    Console.WriteLine("Введите PIN: ");
                    pin3 = Convert.ToInt32(Console.ReadLine());
                    i++;
                } while (pin3 != pin && i < 4);
                if (pin3 == pin)
                    Console.WriteLine(balance);
                else
                {
                    do
                    {
                        Console.WriteLine("Введите PIN: ");
                        pin3 = Convert.ToInt32(Console.ReadLine());
                        i++;
                    } while (pin3 != pin2);
                    if (pin3 == pin2)
                        Console.WriteLine(balance);
                }
            }

        }
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            CreditCard creditCard = new CreditCard();
            creditCard.CheckBal1();
        }
    }
}
