using System;
using System.Collections;
using System.Collections.Generic;
namespace podgotovka
{
    class Program
    {
        class Location
        {
            public int lat;
            public int long1;
            public int speed;

        }

        public class Taxi
        {
            public string number;

            Location firstTaxiLoc = new Location();

            public Taxi(int lat, int long1, int speed)
            {
                firstTaxiLoc.lat = lat;
                firstTaxiLoc.long1 = long1;
                firstTaxiLoc.speed = speed;
            }
            enum status
            {
                busy,
                free
            }
        }

        public class Park<T>
        {
            List<Taxi> Taxis = new List<Taxi>();
            public void Add(Taxi a) 
            {
                 Taxis.Add(a);
            }
            public void Remove(Taxi a)
            {
                Taxis.Remove(a);
            }
            
            public void Clear(Taxi a)
            {
                Taxis.Clear();
            }

            Predicate<string> isFree = delegate (string number)
            {

                return number.Equals("0");
            };
            
            public void Find()
            {

            }

            
        }
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            Park<Taxi> uber = new Park<Taxi>();
            
            uber.Add(new Taxi(10, 10, 10));
            uber.Add(new Taxi(55, 44, 20));
            uber.Add(new Taxi(10, 78, 22));
            uber.Add(new Taxi(80, 33, 48));
        }
       
    }
}
