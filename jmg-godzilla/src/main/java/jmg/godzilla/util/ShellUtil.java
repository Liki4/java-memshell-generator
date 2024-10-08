package jmg.godzilla.util;

import jmg.core.config.Constants;
import jmg.godzilla.memshell.*;

import java.util.HashMap;
import java.util.Map;

public class ShellUtil {

    private static final Map<String, String> SHELL_CLASSNAME_MAP = new HashMap();
    private static final Map<String, Map<String, String>> toolMap = new HashMap();

    public ShellUtil() {
    }

    public static String getShellName(String toolType, String shellType) {
        Map<String, String> shellMap = toolMap.get(toolType);
        return shellMap == null ? "" : shellMap.getOrDefault(shellType, "");
    }

    public static String getShellClassName(String shellName) throws Exception {
        if (SHELL_CLASSNAME_MAP.get(shellName) == null) {
            throw new Exception("Invalid shell type '" + shellName + "'");
        } else {
            return SHELL_CLASSNAME_MAP.getOrDefault(shellName, "");
        }
    }

    static {
        SHELL_CLASSNAME_MAP.put(GodzillaFilter.class.getSimpleName(), GodzillaFilter.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaListener.class.getSimpleName(), GodzillaListener.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaInterceptor.class.getSimpleName(), GodzillaInterceptor.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaWebFluxHandlerMethod.class.getSimpleName(), GodzillaWebFluxHandlerMethod.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaJakartaFilter.class.getSimpleName(), GodzillaJakartaFilter.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaJakartaListener.class.getSimpleName(), GodzillaJakartaListener.class.getName());
        SHELL_CLASSNAME_MAP.put(GodzillaValve.class.getSimpleName(), GodzillaValve.class.getName());

        Map<String, String> godzillaMap = new HashMap();
        godzillaMap.put(Constants.SHELL_FILTER, GodzillaFilter.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_LISTENER, GodzillaListener.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_INTERCEPTOR, GodzillaInterceptor.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_WF_HANDLERMETHOD, GodzillaWebFluxHandlerMethod.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_JAKARTA_FILTER, GodzillaJakartaFilter.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_JAKARTA_LISTENER, GodzillaJakartaListener.class.getSimpleName());
        godzillaMap.put(Constants.SHELL_VALVE, GodzillaValve.class.getSimpleName());

        toolMap.put(Constants.TOOL_GODZILLA, godzillaMap);
    }


}
