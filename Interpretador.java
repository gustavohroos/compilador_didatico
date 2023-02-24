public class Interpretador {

    public Interpretador() {}

    int executa(ArvoreSintatica arv) {
        return executa2(arv);
    }

    int executa2(ArvoreSintatica arv){
        if (arv instanceof Mult)
            return (executa2(((Mult) arv).arg1) * executa2(((Mult) arv).arg2));

        if (arv instanceof Soma)
            return (executa2(((Soma) arv).arg1) + executa2(((Soma) arv).arg2));

        if (arv instanceof Div)
            return (executa2(((Div) arv).arg1) / executa2(((Div) arv).arg2));

        if (arv instanceof Sub)
            return (executa2(((Sub) arv).arg1) - executa2(((Sub) arv).arg2));

        if (arv instanceof Num)
            return ((Num) arv).num;

        return 0;
    }

}
