var funсt = function(string) {
    var x = string.split('');
    var y=0;
    var str ='';
    var dygyt  =  /\d/g;
    for (y=0; y<x.length;y++)
    {
        if (x[y] === "=" ){
            print(str + ' is a number');
            str='';
            print(x[y]+' is a equality');
        }
        else if (x[y] === '-' || x[y] === '+'){
            print(str + ' is a number');
            str='';
            print(x[y]+' is a operator')

        }
        else if (x[y] === ';'){
            print(str + ' is a number');
            str='';
            print(x[y]+' is a end of line')

        }
        else if (x[y] === '('||x[y]===')'){

        }
        else {

                     str = str + x[y];




        }

    }
};
