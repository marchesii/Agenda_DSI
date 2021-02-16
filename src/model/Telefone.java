package model;

public class Telefone {
	private int ddd;
	private int prefixo;
	private int sufixo;
	
	public Telefone (int ddd, int prefixo, int sufixo) {
		
		setDdd(ddd);
		setPrefixo(prefixo);
		setSufixo(sufixo);
		
	}
	
	public Telefone () {
		this.ddd = 0;
		this.prefixo = 0;
		this.sufixo = 0;
	}
	
	public void setDdd(int ddd) {
		if(ddd > 99 || ddd < 0) {
			this.ddd = 0;
		}else {
			this.ddd = ddd;
		}
	}
	
	public void setPrefixo(int prefixo) {
		if(prefixo > 9999 || prefixo < 0) {
			this.prefixo = 0;
		}else {
			this.prefixo = prefixo;
		}
	}
	
	public void setSufixo(int sufixo) {
		if(sufixo > 9999 || sufixo < 0) {
			this.sufixo = 0;
		}else {
			this.sufixo = sufixo;
		}
	}
	
	@Override
	public String toString(){
		
		String result;
	
		result = " " + ddd + " ";
			
		if((prefixo < 1) || (prefixo < 10))
		{
			result += " 000" + prefixo + " ";
		}else {
			if(prefixo < 100)
			{
				result += " 00" + prefixo + " "; 
			}else {
				if(prefixo < 1000)
				{
					result += " 0" + prefixo + " ";
				}else {
					result += " " + prefixo + " ";
				}
			}
		}
		
		if((sufixo < 1) || (sufixo < 10))
		{
			result += "- 000" + sufixo + "\n";
		}else {
			if(sufixo < 100)
			{
				result += "- 00" + sufixo + "\n"; 
			}else {
				if(sufixo < 1000)
				{
					result += "- 0" + sufixo + "\n";
				}else {
					result += "- " + sufixo + "\n";
				}
			}
		}
		return result;
	}
	
}
