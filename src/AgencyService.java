public interface AgencyService {
   void  addAgency(Agency agency);
   Agency getAgencyById(Long id);
    Agency[] getAllAgency();
    void updateAgency(long id,Agency newAgency);
    void deleteAgency(long id);
}
