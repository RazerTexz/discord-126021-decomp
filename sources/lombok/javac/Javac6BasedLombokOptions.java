package lombok.javac;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;
import lombok.permit.Permit;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/Javac6BasedLombokOptions.SCL.lombok */
public class Javac6BasedLombokOptions extends LombokOptions {
    private static final Method optionName_valueOf;
    private static final Method options_put;

    static {
        try {
            Class<?> optionNameClass = Class.forName("com.sun.tools.javac.main.OptionName");
            optionName_valueOf = Permit.getMethod(optionNameClass, "valueOf", String.class);
            options_put = Permit.getMethod(Class.forName("com.sun.tools.javac.util.Options"), "put", optionNameClass, String.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't initialize Javac6-based lombok options due to reflection issue.", e);
        }
    }

    public static Javac6BasedLombokOptions replaceWithDelombokOptions(Context context) {
        Options options = Options.instance(context);
        context.put(optionsKey, (Object) null);
        Javac6BasedLombokOptions result = new Javac6BasedLombokOptions(context);
        result.putAll(options);
        return result;
    }

    private Javac6BasedLombokOptions(Context context) {
        super(context);
    }

    @Override // lombok.javac.LombokOptions
    public void putJavacOption(String optionName, String value) {
        try {
            options_put.invoke(this, optionName_valueOf.invoke(null, optionName), value);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Can't initialize Javac6-based lombok options due to reflection issue.", e);
        } catch (InvocationTargetException e2) {
            throw Lombok.sneakyThrow(e2.getCause());
        }
    }
}
