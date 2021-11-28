public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;
        int currAlt = status.getAltitude();
        int currVel = status.getVelocity();

        if (currAlt > 4000){
            if ((currVel-100) >= 400) {
                burn = 200;
            } else {
                burn = 100;
            }
        } else if (currAlt > 100) {
            if (currAlt < 200 && currAlt%100 != 0) {
                burn = 200 - currAlt%100;
            } else if ((currVel-100) >= 100) {
                burn = 200;
            } else {
                burn = 100;
            }
        } else if(currAlt == 100){
            if(currVel == 100){
                burn = 150;
            } else if (currVel >= 50){
                burn = 100 + currVel - 50;
            } else {
                burn = 100 - (50 - currVel);
            }
        } else {
            if (currAlt == 50) {
                burn = 125;
            } else if (currAlt > 20) {
                burn = 120;
            } else if (currAlt > 5) {
                burn = 100;
            } else if (currAlt == 5) {
                burn = 103;
            } else {
                burn = 100;
            }
        }

        if(burn > 200){
            burn = 200;
        }

        System.out.println(burn); /*hack!*/
        return burn;
    }

}
