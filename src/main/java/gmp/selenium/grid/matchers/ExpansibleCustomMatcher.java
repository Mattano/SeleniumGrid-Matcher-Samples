package gmp.selenium.grid.matchers;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;

/**
 * Matcher que facilita adicao de novas capabilities
 */
public class ExpansibleCustomMatcher extends DefaultCapabilityMatcher {

    Map<String,Object> nodeCapability;
    Map<String,Object> requestedCapability;


    @Override
    public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {
        this.nodeCapability = nodeCapability;
        this.requestedCapability = requestedCapability;


        //Capabilities adicionais
        String udid = "udid";

        boolean basicChecks = super.matches(nodeCapability, requestedCapability);


        // Se a requisicao nao possuir as capabilities personalizada, retorne a validacao padrao
        if (!contailsAllCustomCapabilities()) {
            return basicChecks;
        }


        // Se possuir capabilities personalizadas, verificar se o node atual atende todas as capabilities personalizadas
            return basicChecks && allCustomCapabilitiesMatch(udid);
    }



    private boolean allCustomCapabilitiesMatch(String... customCapabilities){
        // Verificar se cada capability personalizada esta presente, retornando falso se nao possuir
        for (String capability: customCapabilities)
        {
              if(!nodeCapability.get(capability).equals(requestedCapability.get(capability)))
              {
                  return false;
              }
        }
        return true;
    }

    private boolean contailsAllCustomCapabilities(String... customCapabilities){
        // Verificar se cada capability personalizada esta presente, retornando falso se nao possuir
        for (String capability: customCapabilities)
        {
            if (!requestedCapability.containsKey(capability)) {
                return false;
            }
        }
        return true;

    }


}
