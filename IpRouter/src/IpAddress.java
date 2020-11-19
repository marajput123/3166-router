import java.util.Scanner;

public class IpAddress {
    public String ipAddress;
    public int[] ipAddressParsed = new int[4];
    public StringBuilder binaryString = new StringBuilder();
    public String newAddress;

    public IpAddress(String Ip){
//        Scanner scanner = new Scanner(System.in);
        System.out.print("IP Address is: ");
        this.ipAddress = Ip;
    }

    public boolean validate(){
        try{
            String[] str = this.ipAddress.split("\\.",0);
            if(str.length != 4){
                throw new Exception();
            }
            for(int i = 0; i < str.length; i++) {
                int octet = Integer.parseInt(str[i]);
                if(octet > 255 || octet < 0){
                    throw new Exception();
                }
                ipAddressParsed[i] = octet;
            }
            return true;
        }catch(Exception e){
            System.out.println("Ip address not correct");
        }
        return false;
    }

    public void convertToBinary(){
        for(int i = 0; i < this.ipAddressParsed.length; i++){
            if (this.ipAddressParsed[i] == 0) {
                this.binaryString = this.binaryString.append("000000000");
                continue;
            }
            String binaryNum = convertToBinary(this.ipAddressParsed[i]);
            this.binaryString = this.binaryString.append(binaryNum);
        }
    }

    private String convertToBinary(int num){
        int binary[] = new int[40];
        String binaryNum = "";
        int index = 0;
        while (num > 0) {
            binary[index] = num % 2;
            binaryNum = binary[index] + binaryNum;
            num = num / 2;
            index++;
        }
        // add leading 0(s) to make sure each binary block has 4 bits
        if (binaryNum.length() % 8 == 0) {
            return binaryNum;
        }
        else {
            int needLeadingZero = 8 - (binaryNum.length() % 8);
            for (int i = 0; i < needLeadingZero; i++) {
                binaryNum = "0" + binaryNum;
            }
            return binaryNum;
        }
    }


    public void getNewAddress(){
        this.binaryString = this.binaryString.delete(this.binaryString.length() - 10, this.binaryString.length()).append("0000000000");
        String ipAddressBlock;
        StringBuilder networkPart = new StringBuilder();
        for (int i = 0, j = 0; i < 4; i++, j += 8) {
            ipAddressBlock = binaryString.substring(j, j + 8);
            int num = Integer.parseInt(ipAddressBlock, 2);
            networkPart = networkPart.append(num);
            if (i < 3)
                networkPart = networkPart.append(".");
        }
        this.newAddress = networkPart.toString() ;
        System.out.println("Network part is: ");
        System.out.println(networkPart);
    }

    public String match(){
        String[] addressTable = {"135.46.56.0", "135.46.60.0", "192.53.40.0"};
        String[] nextHop = {"Interface 0", "Interface 1", "Router 1"};
        String defaultRouter = "Router 2";
        Boolean matching;
        for (int i = 0; i < addressTable.length; i++) {
            if (this.newAddress.equals(addressTable[i]))
                return addressTable[i] + "-" + nextHop[i];
        }
        return "Default-" + defaultRouter;
    }

    public void printAllRoutes(){
        System.out.println("---------------");
        String[] addressTable = {"135.46.56.0 - interface 0", "135.46.60.0 - interface 1", "192.53.40.0 - Router 1", "Default - Router 2"};
        for(int i = 0;i < addressTable.length; i++){
            System.out.println(addressTable[i]);
        }
        System.out.println("----------------");
    }

}
