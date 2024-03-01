package safrilar.packges.util;

import java.lang.reflect.Field;

public class Util {

    public static void copiarCamposNaoNulos(Object fonte, Object destino) throws IllegalAccessException {

        Class<?> fonteClasse = fonte.getClass();
        Class<?> destinoClasse = destino.getClass();

        Field[] camposFonte = fonteClasse.getDeclaredFields();
        for (Field campo : camposFonte) {
            campo.setAccessible(true);

            Object value = campo.get(fonte);
            if (value != null) {
                Field campoDestino;
                try {
                    campoDestino = destinoClasse.getDeclaredField(campo.getName());
                    campoDestino.setAccessible(true);
                    campoDestino.set(destino, value);
                } catch (NoSuchFieldException e) {

                }
            }
        }
    }
}
