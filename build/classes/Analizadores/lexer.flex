package Analizadores;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%unicode
%line
%column
%char
%public
espacio=[\t|\r|\n]+
esp = [ ]+
%state STRING
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* palabras reservadas */
<YYINITIAL>{
"Usuario"                       {return new Symbol(sym.USUARIO, yycolumn, yyline, yytext());}
","                             {return new Symbol(sym.COMA,yycolumn,yyline,yytext());}
"\""                            {yybegin(STRING); return new Symbol(sym.COMILLAS,yycolumn,yyline,yytext());}
"Estudiante"                    {return new Symbol(sym.ESTUDIANTE, yycolumn, yyline, yytext());}
"Catedratico"                   {return new Symbol(sym.CATEDRATICO, yycolumn, yyline, yytext());}
"Edificio"                      {return new Symbol(sym.EDIFICIO, yycolumn, yyline, yytext());}
"Salon"                         {return new Symbol(sym.SALON, yycolumn, yyline, yytext());}
"Curso"                         {return new Symbol(sym.CURSO, yycolumn, yyline, yytext());}
"Horario"                       {return new Symbol(sym.HORARIO,yycolumn,yyline,yytext());}
"Asignar"                       {return new Symbol(sym.ASIGNAR,yycolumn,yyline,yytext());}
"super"                         {return new Symbol(sym.SUPER,yycolumn,yyline,yytext());}
"colaborador"                   {return new Symbol(sym.COLABORADOR,yycolumn,yyline,yytext());}
"estudiante"                    {return new Symbol(sym.ESTUDIANTEP,yycolumn,yyline,yytext());}
[1-9][0-9]*                     {return new Symbol(sym.NUMERO,yycolumn,yyline,yytext());}
"("                             {return new Symbol(sym.PARENTESISA,yycolumn,yyline,yytext());}
")"                             {return new Symbol(sym.PARENTESISC,yycolumn,yyline,yytext());}
";"                             {return new Symbol(sym.PUNTOC,yycolumn,yyline,yytext());}
[a-zA-Z]+[0-9]+                 {return new Symbol(sym.ID,yycolumn,yyline,yytext());}
{espacio}                       {}
{esp}                           {}
[^]                             {}
}

<STRING>{
    ("\"")                      {yybegin(YYINITIAL); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
    [^"\""]+                       {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
}
