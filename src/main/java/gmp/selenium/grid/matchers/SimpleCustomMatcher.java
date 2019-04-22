package gmp.selenium.grid.matchers;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;

/**
 * Matcher simples que verifica uma capability adicional
 */
public class SimpleCustomMatcher extends DefaultCapabilityMatcher {


    @Override
    public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {

        //Capabilities adicionais
        String udid = "udid";

        boolean basicChecks = super.matches(nodeCapability, requestedCapability);


        // Se a requisicao nao possuir as capabilities personalizada, retorne a validacao padrao
        if (!nodeCapability.containsKey(udid)) {
            return basicChecks;
        }


        // Se possuir capabilities personalizadas, verificar se o node atual atende todas as capabilities personalizadas
            return basicChecks && nodeCapability.get(udid).equals(requestedCapability.get(udid));
    }


    }