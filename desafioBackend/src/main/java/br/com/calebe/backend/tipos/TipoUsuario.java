package br.com.calebe.backend.tipos;

public enum TipoUsuario {
	
	ADMINISTRADOR("Administrador"), USUARIO_TRIADOR("Usuário-triador"), USUARIO_FINALIZADOR("Usuário-finalizador");
	
	private String descricao;

	TipoUsuario(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoUsuario get( String nome ) {
        for ( TipoUsuario tipoUsuario : TipoUsuario.values() ) {
            if ( tipoUsuario.getDescricao().equals( nome ) || tipoUsuario.name().equals( nome ) ) {
                return tipoUsuario;
            }
        }
        return null;
    }
	
	public static TipoUsuario get( int numero ) {
        for ( TipoUsuario tipoUsuario : TipoUsuario.values() ) {
            if ( tipoUsuario.ordinal() == numero ) {
                return tipoUsuario;
            }
        }
        return null;
    }
	
}
