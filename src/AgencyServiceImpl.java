public class AgencyServiceImpl implements AgencyService{
    Agency[] agencies=new Agency[10];
    int count;

    @Override
    public void addAgency(Agency agency) {
agencies[count++]=agency;
    }

    @Override
    public Agency getAgencyById(Long id) {
        try {
            if (id < 0 || id == 0) {
                throw new RuntimeException("Id ters bolbosh kerek je id 0 go barabar bolbosh kerek");
            }

            for (Agency a: agencies) {
                if (a.getId() == id) {
                    return a;
                } else {
                    throw new NullPointerException("Myndai id menen Agent  baza jok");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    @Override
    public Agency[] getAllAgency() {
        return agencies;
    }

    @Override
    public void updateAgency(long id, Agency newAgency) {
        for (int i = 0; i < count; i++) {
            if (agencies[i].getId()==id){
                agencies[i]=newAgency;
            }
            return;
        }
        System.out.println("AGENTSTVO NE NAIDENO ");
    }


    @Override
    public void deleteAgency(long id) {
        int index = -1;

        // ochurulo turgan indexti izdep taptyk
        for (int i = 0; i < agencies.length; i++) {
            if (agencies[i].getId() == id) {
                index = i;
                break;
            }
        }
        System.out.println(index);



        Agency[] newAcence = new Agency[agencies.length - 1];

        // tabylgan index ke cheiinki dannyilardy
        // jany massivdin ichine saktaibyz
        for (int i = 0; i < index; i++) {
            newAcence[i] = agencies[i];
        }

        // tabylgan index ke kiinki  dannyilardy
        // jany massivdin ichine saktaibyz
        for (int i = index; i < newAcence.length; i++) {
            newAcence[i] = agencies[i + 1];
        }

        agencies = newAcence;
    }
}


