using System;

namespace Application
{
    class Proga
    {


        delegate void somedelegate();


        class startpoint
        {

            public startpoint(int x, int y)
            {
                this.x = x;
                this.y = y;
            }

            public int x { get; set; }
            public int y { get; set; }
        }

        class Button
        {

            startpoint startpoint = new startpoint(10, 20);

            public string caption { get; set; }
            public int h { get; set; }
            public int w { get; set; }

        }

        class CheckButton : Button
        {

            public void Chech()
            {

                state = state + 1;

            }

            public void Zoom(int procent)
            {
                Console.WriteLine($"Введённый процент: {procent}");
                int newZoom = w * h * procent / 100;
                Console.WriteLine(newZoom);
            }

            public state state { get; set; }

            public override string ToString()
            {
                Console.WriteLine(state);
                return "0";
            }

            public override bool Equals(object obj)
            {
                Button button = (Button)obj;
                if (button == null)
                    return false;

                if (this.caption == button.caption)
                {
                    if (this.h == button.h)
                    {
                        if (this.w == button.w)
                        {
                            return true;
                        }

                    }

                }

                return false;

            }
        }

        enum state
        {
            //checked - ключевое слово
            cchecked,
            uncheked
        }

       

        class MainClass
        {
            public static void Main(string[] args)
            {
                Console.WriteLine("Hello World!");
                CheckButton but1 = new CheckButton();
                CheckButton but2 = new CheckButton();
                User user1 = new User();
                //but1.Chech() += Click;//подписка на клик
                // but2.Zoom() += Resize;//подписка на ресайз
            }
        }
        public class User
        {
            somedelegate _del;//создал экземпляр

            // ??
            public event somedelegate Click;
            public event somedelegate Resize;
        }
    }
}