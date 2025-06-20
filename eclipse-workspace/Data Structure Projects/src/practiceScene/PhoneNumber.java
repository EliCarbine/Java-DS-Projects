package practiceScene;

public class PhoneNumber {
    private int areaCode, prefix, lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
       
        if (areaCode < 0 || areaCode > 999 || prefix < 0 || prefix > 999 || lineNumber < 0 || lineNumber > 9999) {
        throw new IllegalArgumentException();	
        }
    }
        		
    

    public PhoneNumber(String fullNumber) {
        String[] tokens = fullNumber.split("-");
        
        if (tokens.length != 3){
        	throw new IllegalArgumentException();
        }
        try {
        areaCode = Integer.parseInt(tokens[0]);
        prefix = Integer.parseInt(tokens[1]);
        lineNumber = Integer.parseInt(tokens[2]);
        
        char [] line1 = tokens[0].toCharArray(); 
        if (line1.length != 3) {
        throw new IllegalArgumentException();	
        }
        line1 = tokens[1].toCharArray();
        if (line1.length != 3) {
          throw new IllegalArgumentException();	
         }
        line1 = tokens[2].toCharArray();
        if (line1.length != 4) {
            throw new IllegalArgumentException();	
        }
        
    	} catch (IllegalArgumentException e) {
    		throw new IllegalArgumentException(e.getMessage());
    	}
    }

    public PhoneNumber(PhoneNumber original) {
        this.areaCode = original.areaCode;
        this.prefix = original.prefix;
        this.lineNumber = original.lineNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PhoneNumber) {
            PhoneNumber other = (PhoneNumber) o;
            return this.areaCode == other.areaCode && this.prefix == other.prefix && this.lineNumber == other.lineNumber;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(areaCode, prefix, lineNumber);
    }
}
