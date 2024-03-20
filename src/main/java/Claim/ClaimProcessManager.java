package Claim;

import java.util.List;

public interface ClaimProcessManager {
    void add();
    void update(String claimId);
    void delete(String claimId);
    Claim getOne(String claimId);
    List<Claim> getAll();
}
