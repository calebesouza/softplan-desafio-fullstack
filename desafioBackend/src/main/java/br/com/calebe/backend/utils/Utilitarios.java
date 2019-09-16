package br.com.calebe.backend.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Utilitarios {

    /**
     * Verifica se um String possui conteúdo válido.
     *
     * @param val String
     * @return boolean true ou false
     */
    public static boolean isOK( String val ) {
        return val != null && !"".equals( val.trim() ) && !"NULL".equals( val.toUpperCase().trim() );
    }

    /**
     * Verifica se um Long possui conteúdo válido.
     *
     * @param val {@link Long}
     * @return boolean true ou false
     */
    public static boolean isOK( Long val ) {
        return val != null && val != 0;
    }

    /**
     * Verifica se um Integer possui conteúdo válido e maior que zero.
     *
     * @param val {@link Long}
     * @return boolean true ou false
     */
    public static boolean isOK( Integer val ) {
        return val != null && val != 0;
    }
    
    /**
     * Verifica se um Boolean possui conteúdo diferente de false ou null.
     *
     * @param val {@link Boolean}
     * @return boolean true ou false
     */
    public static boolean isOK( Boolean val ) {
        return val != null && !Boolean.FALSE.equals( val );
    }
    
    /**
     * Verifica se um Number possui conteúdo válido e maior que zero.
     *
     * @param val {@link Number}
     * @return boolean true ou false
     */
    public static boolean isOK( Number val ) {
        return val != null && val.longValue() != 0 && !( val.doubleValue() == 0.0 );
    }

    /**
     * Verifica se uma Collection possui conteúdo válido.
     *
     * @param val {@link Collection}
     * @return boolean true ou false
     */
    public static boolean isOK( Collection<?> val ) {
        return val != null && !val.isEmpty();
    }

    /**
     * Verifica se um Map possui conteúdo válido.
     *
     * @param val {@link Map}
     * @return boolean true ou false
     */
    public static boolean isOK( Map<?, ?> val ) {
        return val != null && !val.isEmpty();
    }
    
    /**
     * Verifica se um Set possui conteúdo válido.
     *
     * @param val {@link Set}
     * @return boolean true ou false
     */
    public static boolean isOK( Set<?> val ) {
        return val != null && !val.isEmpty();
    }
    
    /**
     * Converte uma lista de String em uma String única, separada por "," e o
     * último item separado por "e"
     *
     * @param lista
     * @return lista formatada
     */
    public static String converteListaEmStringComVirgulas( List<String> lista ) {
        String formatado = "";
        switch ( lista.size() ) {
            case 1:
                return lista.get( 0 );
            case 2:
                return lista.get( 0 ) + " e " + lista.get( 1 );
        }
        for ( String s : lista ) {
            if ( lista.indexOf( s ) == lista.size() - 1 ) {
                formatado += s;
                continue;
            }
            if ( lista.indexOf( s ) == lista.size() - 2 ) {
                formatado += s + " e ";
                continue;
            }
            formatado += s + ", ";
        }
        return formatado;
    }
    
    public static String encriptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes("UTF-8"));
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
    
}
