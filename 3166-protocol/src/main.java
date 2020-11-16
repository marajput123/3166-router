public class main {
    public static void main(String[] args) {
        while(true) {
            IpAddress routerOne = new IpAddress();
            routerOne.printAllRoutes();
            if(!routerOne.validate()){
                break;
            }
            routerOne.convertToBinary();
            routerOne.getNewAddress();
            System.out.println(routerOne.match());
            break;
        }
    }
}
