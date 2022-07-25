package alura.filme;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        /** leitura da imagem **/
//        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme2.jpg")); /** 1 passo **/
//----------------------------------------------------------------------------------------------------------
//        InputStream inputStream = new FileInputStream(new File("entrada/filme2.jpg")); /** 2 passo **/
//        BufferedImage imagemOriginal = ImageIO.read(inputStream);
//----------------------------------------------------------------------------------------------------------
//        InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream(); /** 3 passo **/
//        BufferedImage imagemOriginal = ImageIO.read(inputStream);
//----------------------------------------------------------------------------------------------------------
        /** 4 passo parâmetro **/
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        /** cria nova imagem em memória com transparência e com tamanho novo **/
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        /** copiar a imagem original pra novo imagem (em memória) **/
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        /** configurar a fonte **/
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.red);

        /** escrever uma frase na nova imagem **/
        graphics.drawString("SONIC 2", 150, novaAltura - 100);

        /** escrever a nova imagem em um arquivo **/
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
