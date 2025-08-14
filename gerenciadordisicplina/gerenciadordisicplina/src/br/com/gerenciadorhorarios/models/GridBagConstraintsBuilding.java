package br.com.gerenciadorhorarios.models;

import java.awt.*;

public class GridBagConstraintsBuilding extends GridBagConstraints {

    /* Considerando a qtd de atributos nao ultilizados da Class GridBagConstraints na
    construcao de objs e a variacao na seletividade de valores especificados como parametros na construcao
    que variam por qtd a depender do obj instanciado, criamos uma class que implementa o padrao Builder
    e atribui valores padroes para os parametros nao especificados na construcao

    ex de instanciacao da class: new GridBagConstraintsBuilding.Builder().metodo1().metodo2()..... metodon().build()
    1 - a class e instanciada
    2 - a classe interna e chamada
    3 - os metodos getters/setters sao chamadaos a depender da necessidade
    4 - fecha com o metodo build() que constroi obj Builder usado como parametro
    para construir a class externa */

    public GridBagConstraintsBuilding(Builder builder) {

        // Construtor recebe objeto Builder como parametro e constroi
        // o obj gbc/gbcb a partir de seus atributos

        this.gridx = builder.gridx;
        this.gridy = builder.gridy;
        this.gridwidth = builder.gridwidth;
        this.gridheight = builder.gridheight;
        this.weightx = builder.weightx;
        this.weighty = builder.weighty;
        this.anchor = builder.anchor;
        this.fill = builder.fill;
        this.insets = builder.insets;
        this.ipadx = builder.ipadx;
        this.ipady = builder.ipady;
    }

    public static class Builder{

        /* os atributos da classe interna tem
         os atributos com valores padrões da class mãe
         para que não haja preocupacao de passá-los
         como paramentros na instanciação*/

        private int gridx = RELATIVE;
        private int gridy = RELATIVE;
        private int gridwidth = 1;
        private int gridheight = 1;
        private double weightx = 0.0;
        private double weighty = 0.0;
        private int anchor = CENTER;
        private int fill = NONE;
        private Insets insets = new Insets(0, 0, 0, 0);
        private int ipadx = 0;
        private int ipady = 0;

        /* metodos setters/getters para atender
         as necessidades de uma construção
         feita apenas de parametros necessários a
         depender da necessidade do obj a ser construido*/

        public Builder gridx(int gridx) { this.gridx = gridx; return this; }
        public Builder gridy(int gridy) { this.gridy = gridy; return this; }
        public Builder gridwidth(int gridwidth) { this.gridwidth = gridwidth; return this; }
        public Builder gridheight(int gridheight) { this.gridheight = gridheight; return this; }
        public Builder weightx(double weightx) { this.weightx = weightx; return this; }
        public Builder weighty(double weighty) { this.weighty = weighty; return this; }
        public Builder anchor(int anchor) { this.anchor = anchor; return this; }
        public Builder fill(int fill) { this.fill = fill; return this; }
        public Builder insets(Insets insets) { this.insets = insets; return this; }
        public Builder ipadx(int ipadx) { this.ipadx = ipadx; return this; }
        public Builder ipady(int ipady) { this.ipady = ipady; return this; }

        public GridBagConstraintsBuilding build(){

            return new GridBagConstraintsBuilding(this); // metodo que instancia obj
            // da classe externa que recebe o obj Builder como parametro para o seu construtor
             }
    }


}
