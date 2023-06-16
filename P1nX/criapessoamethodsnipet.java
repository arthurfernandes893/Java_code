   public PessoaIMC criapessoa() throws IOException,NomeErradoException,DataErradaException,PesoEAlturaErradoException{
        //criar buffer fora do try/catch //
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        // variaveis auxiliares//
        String nome = ""; String sobrenome; String line; String empty = "";
        float peso, altura; 
        GregorianCalendar data;
        
        //nome//
        try{
        System.out.println("Se desejar encerrar a execução, pressione enter\nInsira o nome:");
        line = inData.readLine();
        if(line.equals(empty)){
            throw new NomeErradoException("campo vazio. deseja continuar inserindo ou encerrar?\t[Y] ou [N]");
        }
        nome = line;
        }
        catch(NomeErradoException e){
            System.out.println(e);
            line = inData.readLine();
            String aux = e.ledireito(line); 
            if ((aux).equals(P2nX.empty)){
                System.exit(1);
            }
            else{
                nome = aux;
            }

        }
        //sobrenome//
        System.out.println("Insira o Sobrenome");
        line = inData.readLine();
        sobrenome = line;
        //nascimento//
        try{
        System.out.println("Insira a data de nascimento na forma ddmmaaaa - SEM BARRA:");
        line = inData.readLine();
        if(!P2nX.checkString(line) || line.length() > 8 || line.length() < 8){
            throw new DataErradaException(line.length(),P2nX.checkString(line));
        }
        int [] data1 = ValidaData.criadata1(line);
        data = new GregorianCalendar(data1[2],data1[1],data1[0]);
        }
        catch(DataErradaException d){
            System.out.println(d);
            data = d.criadatacerta(line);
        }
        //peso//
        try{        
        System.out.println("Peso (em Kg):");
        line = inData.readLine();
        if(!P2nX.checkString(line) || Float.parseFloat(line) < 1 || Float.parseFloat(line) > 200){
            throw new PesoEAlturaErradoException("peso");
        }
        peso = Float.parseFloat(line);
        }    
        catch(PesoEAlturaErradoException p){
            System.out.println(p);
            peso = p.criapesocerto(line);
        }
        //altura//
        try{        
            System.out.println("Altura (em metros):");
            line = inData.readLine();
            if(!P2nX.checkString(line) || Float.parseFloat(line) < 0.5 || Float.parseFloat(line) > 3){
                throw new PesoEAlturaErradoException("altura");
            }
            altura = Float.parseFloat(line);
            }    
        catch(PesoEAlturaErradoException p){
            System.out.println(p);
            altura = p.criaalturacerta(line);
        }
        //genero, para a criacao dos objetos//
        System.out.println("Qual o genero?");
        System.out.println("[1]: Masculino e [2]: Feminino");
        line = inData.readLine();
        while(!P2nX.checkString(line) || Integer.parseInt(line) >2 || Integer.parseInt(line)<1){
            System.out.println("Informação inserida de forma errada. Insira Novamente:");
            System.out.println("[1]: Masculino e [2]: Feminino");
            line = inData.readLine();
        }
        if(Integer.parseInt(line) == 1){
            Homem h = new Homem(nome,sobrenome,data,peso,altura);
            PessoaIMC pessoa = (PessoaIMC) h;
            return pessoa;
        }
        else{
            Mulher h = new Mulher(nome,sobrenome,data,peso,altura);
            PessoaIMC pessoa = (PessoaIMC) h;
            return pessoa;
        }
    }
    