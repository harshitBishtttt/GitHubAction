package cloud.controller;

import cloud.dto.DeploymentResponse;
import cloud.dto.DeploymentResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DeploymentController {

    @GetMapping("/deployment-info")
    ResponseEntity<DeploymentResponseList> getAllEnvironments() {
        return ResponseEntity.ok().body(fetchEnvironmentsFromDb());
    }
//
    private DeploymentResponseList fetchEnvironmentsFromDb() {
        DeploymentResponseList environments = new DeploymentResponseList();
        DeploymentResponse uat = new DeploymentResponse();
        uat.setEnvironment("uat");
        uat.setRegion("us-east-1");
        uat.setInstanceType("t3.medium");
        uat.setReplicaCount(2);
        uat.setAutoscalingEnabled(true);
        uat.setMaxInstances(5);
        uat.setMinInstances(1);
        uat.setDatabaseUrl("uat-db.example.com");
        uat.setStorageBucket("uat-bucket");
        uat.setLoggingLevel("debug");
        uat.setApiGatewayUrl("https://api-uat.example.com");
        uat.setFeatureFlags(Arrays.asList("betaFeature", "loggingV2"));
        uat.setMaintenanceWindow("Sunday 02:00-03:00 UTC");
        uat.setBackupEnabled(true);
        uat.setMonitoringEnabled(true);
        uat.setAlertEmail("uat-alerts@example.com");
        uat.setDeploymentVersion("v1.2.0-uat");
        uat.setSslEnabled(true);
        uat.setAllowedIps(Arrays.asList("192.168.1.0/24"));
        uat.setConfigChecksum("abc123uat");

        DeploymentResponse sandbox = new DeploymentResponse();
        sandbox.setEnvironment("sandbox");
        sandbox.setRegion("us-west-2");
        sandbox.setInstanceType("t3.small");
        sandbox.setReplicaCount(1);
        sandbox.setAutoscalingEnabled(false);
        sandbox.setMaxInstances(2);
        sandbox.setMinInstances(1);
        sandbox.setDatabaseUrl("sandbox-db.example.com");
        sandbox.setStorageBucket("sandbox-bucket");
        sandbox.setLoggingLevel("info");
        sandbox.setApiGatewayUrl("https://api-sandbox.example.com");
        sandbox.setFeatureFlags(Arrays.asList("sandboxMode"));
        sandbox.setMaintenanceWindow("Saturday 01:00-02:00 UTC");
        //
        sandbox.setBackupEnabled(false);
        sandbox.setMonitoringEnabled(true);
        sandbox.setAlertEmail("sandbox-alerts@example.com");
        sandbox.setDeploymentVersion("v1.2.0-sandbox");
        sandbox.setSslEnabled(false);
        sandbox.setAllowedIps(Arrays.asList("10.0.0.0/16"));
        sandbox.setConfigChecksum("abc123sandbox");

        DeploymentResponse production = new DeploymentResponse();
        production.setEnvironment("production");
        production.setRegion("us-east-2");
        production.setInstanceType("m5.large");
        production.setReplicaCount(4);
        production.setAutoscalingEnabled(true);
        production.setMaxInstances(10);
        production.setMinInstances(2);
        production.setDatabaseUrl("prod-db.example.com");
        production.setStorageBucket("prod-bucket");
        production.setLoggingLevel("error");
        production.setApiGatewayUrl("https://api.example.com");
        production.setFeatureFlags(Arrays.asList("stableRelease", "auditTrail"));
        production.setMaintenanceWindow("Wednesday 03:00-04:00 UTC");
        production.setBackupEnabled(true);
        production.setMonitoringEnabled(true);
        production.setAlertEmail("prod-alerts@example.com");
        production.setDeploymentVersion("v1.2.0");
        production.setSslEnabled(true);
        production.setAllowedIps(Arrays.asList("0.0.0.0/0"));
        production.setConfigChecksum("abc123prod");
        List<DeploymentResponse> list = Arrays.asList(uat, sandbox, production);
        environments.setEnvironments(list);
        return environments;
    }
}
