public class Solution {
    public String validIPAddress(String ip) {
        if (isValidIPv4(ip))
            return "IPv4";
        else if (isValidIPv6(ip))
            return "IPv6";
        else
            return "Neither";
    }

    public boolean isValidIPv4(String ip) {
        if (countChar(ip, '.') != 3) return false;
        if (ip.length() < 7) return false;

        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) return false;

        for (String token : tokens) {
            if (!isValidIpv4Token(token))
                return false;
        }

        return true;
    }

    public boolean isValidIPv6(String ip) {
        if (countChar(ip, ':') != 7) return false;
        if (ip.length() < 15) return false;

        String[] tokens = ip.split(":");
        if (tokens.length != 8) return false;

        for (String token : tokens) {
            if (!isValidIpv6Token(token))
                return false;
        }

        return true;
    }

    public boolean isValidIpv4Token(String token) {
        if(token.length() == 0 || token.length() > 3)
            return false;
        if (token.startsWith("0") && token.length() > 1)
            return false;

        if (!isNumeric(token))
            return false;
        int val = Integer.parseInt(token);
        if (val < 0 || val > 255)
            return false;

        return true;
    }

    public boolean isValidIpv6Token(String token) {
        if (token.length() > 4 || token.length() == 0)
            return false;

        for (Character c : token.toCharArray()) {
            if (!isHexadecimal(c))
                return false;
        }

        return true;
    }

    int countChar(String str, char c){
        int count = 0;
        for(char ch: str.toCharArray()){
            if(ch == c) count++;
        }
        return count;
    }

    public boolean isHexadecimal(char c) {
        return ((c >='a' && c <= 'f') || (c >= 'A' && c <= 'F') || Character.isDigit(c));
    }

    public boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }

        return true;
    }
}
