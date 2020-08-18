package net.stickycode.plugin.kuuty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.yaml.snakeyaml.Yaml;

import net.stickycode.kuuty.model.v18.IoK8sApiCoreV1Secret;

@Mojo(threadSafe = true, name = "create-secret", requiresDirectInvocation = false, requiresProject = true, defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class KuutyGenerateSecretMojo
    extends AbstractMojo {

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    IoK8sApiCoreV1Secret secret = new IoK8sApiCoreV1Secret();

    Yaml yaml = new Yaml();
    try {
      yaml.dump(secret, new FileWriter(new File("target/secret.yaml")));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
