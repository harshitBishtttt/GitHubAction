package cloud.dto;

import java.util.List;

public class DeploymentResponseList {
    private List<DeploymentResponse> environments;

    public List<DeploymentResponse> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<DeploymentResponse> environments) {
        this.environments = environments;
    }
}
