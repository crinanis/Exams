using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;

namespace podgotovka
{
    class Program
    {
        interface INumber
        {
            public int Number { get; set; }
        }
        public class Bill : INumber
        {
            public int Number
            {
                get { return Number; }
                set {
                    if (value == 5 && value == 10 && value == 20 && value == 30 && value == 40 && value !=0) Number = value;
                    else throw new Exception();
                }
            }
        }

        public class Wallet<T> where T : Bill
        {
            List<int> bills = new List<int>();
            public void Add(int a)
            {
                bills.Add(a);
            }
            public void Remove(int a)
            {
                if (a < 10)
                {
                    if (a < 20)
                    {
                        if (a < 30)
                        {
                            if (a < 40)
                            {
                                bills.Remove(a);
                            }
                            else bills.Remove(a);
                        }
                        else bills.Remove(a);
                    }
                    else bills.Remove(a);
                }
               else bills.Remove(a);
            }
           

        }
        static void JsonSerialize(object obj)
        {
            DataContractJsonSerializer json = new DataContractJsonSerializer(typeof(Bill));
            using (Stream fileStream = new FileStream("BillObjJson.json", FileMode.Create, FileAccess.Write, FileShare.None))
            {
                json.WriteObject(fileStream, obj);
            }
        }
        static void Main(string[] args)
        {
            Wallet<Bill> wallet = new Wallet<Bill>();
            wallet.Add(40);
            wallet.Add(30);
            wallet.Remove(20);
            

        }
    }
}
