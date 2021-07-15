class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        long divid = Math.abs((long)numerator), divis = Math.abs((long)denominator);

        StringBuilder sb = new StringBuilder();
        sb.append(sign);
        sb.append(divid / divis);
        divid %= divis;
        if (divid == 0) return sb.toString();
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (divid != 0) {
            if (map.containsKey(divid)) {
                sb.insert(map.get(divid), "(");
                sb.append(")");
                break;
            } else {
                map.put(divid, sb.length());
                divid *= 10;
                sb.append(divid / divis);
                divid %= divis;
            }
        }
        return sb.toString();
    }
}
