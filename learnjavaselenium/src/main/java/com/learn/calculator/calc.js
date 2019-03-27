Memory = "0";
Current = "0";
Operation = 0;
MAXLENGTH = 30;

function Adddigit(dig)
{ if (Current.length > MAXLENGTH)
	{ Current = "Too long";
else
	{ if ((eval(Current) == 0)
		&& (Current.indexOf(".")== -1)
		)
		{Current = dig;
		}
		else
		(Current = Current + dig;
		};
	}; };
	calculator.Display.value = Current;
	}
	
	function Clear()                //CLEAR ENTRY
 { Current = "0";
   Calculator.Display.value = Current;
 }

function AllClear()             //Clear ALL entries!
 { Current = "0";
   Operation = 0;                //clear operation
   Memory = "0";                  //clear memory
   Calculator.Display.value = Current;
 }
 
 
 function Operate(op)            //STORE OPERATION e.g. + * / etc.
 {
  if (op.indexOf("*") > -1) { Operation = 1; };       //codes for *
  if (op.indexOf("/") > -1) { Operation = 2; };       // slash (divide)
  if (op.indexOf("+") > -1) { Operation = 3; };       // sum
  if (op.indexOf("-") > -1) { Operation = 4; };       // difference

  Memory = Current;                 //store value
  Current = "";                     //or we could use "0"
  Calculator.Display.value = Current;
 }
 
 
 function Calculate()            //PERFORM CALCULATION (= button)
 { 
  if (Operation == 1) { Current = eval(Memory) * eval(Current); };
  if (Operation == 2) { Current = eval(Memory) / eval(Current); };
  if (Operation == 3) { Current = eval(Memory) + eval(Current); };
  if (Operation == 4) { Current = eval(Memory) - eval(Current); };
  Operation = 0;                //clear operation
  Memory    = "0";              //clear memory
  Calculator.Display.value = Current;
 }
 
 
 