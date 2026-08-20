package lombok.patcher.inject;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import lombok.patcher.ClassRootFinder;

/* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/inject/LiveInjector.SCL.lombok */
public class LiveInjector {

    /* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/inject/LiveInjector$LibInstrument.SCL.lombok */
    public interface LibInstrument extends Library {
        void Agent_OnAttach(Pointer pointer, String str, Pointer pointer2);
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/inject/LiveInjector$LibJVM.SCL.lombok */
    public interface LibJVM extends Library {
        int JNI_GetCreatedJavaVMs(PointerByReference pointerByReference, int i, IntByReference intByReference);
    }

    public void injectSelf() throws IllegalStateException {
        inject(ClassRootFinder.findClassRootOfSelf());
    }

    public void inject(String jarFile) throws IllegalStateException {
        File f = new File(jarFile);
        if (!f.isFile()) {
            throw new IllegalArgumentException("Live Injection is not possible unless the classpath root to inject is a jar file.");
        }
        if (System.getProperty("lombok.patcher.safeInject", null) != null) {
            slowInject(jarFile);
        } else {
            fastInject(jarFile);
        }
    }

    private void fastInject(String jarFile) throws IllegalStateException {
        try {
            Class.forName("sun.instrument.InstrumentationImpl");
            LibJVM libjvm = (LibJVM) Native.load(LibJVM.class);
            PointerByReference vms = new PointerByReference();
            IntByReference found = new IntByReference();
            libjvm.JNI_GetCreatedJavaVMs(vms, 1, found);
            LibInstrument libinstrument = (LibInstrument) Native.load(LibInstrument.class);
            Pointer vm = vms.getValue();
            libinstrument.Agent_OnAttach(vm, jarFile, null);
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("agent injection only works on a sun-derived 1.6 or higher VM");
        }
    }

    private void slowInject(String jarFile) throws IllegalStateException {
        String ownPidS = ManagementFactory.getRuntimeMXBean().getName();
        int ownPid = Integer.parseInt(ownPidS.substring(0, ownPidS.indexOf(64)));
        boolean unsupportedEnvironment = false;
        Throwable exception = null;
        try {
            Class<?> vmClass = Class.forName("com.sun.tools.attach.VirtualMachine");
            Object vm = vmClass.getMethod("attach", String.class).invoke(null, String.valueOf(ownPid));
            vmClass.getMethod("loadAgent", String.class).invoke(vm, jarFile);
        } catch (ClassNotFoundException unused) {
            unsupportedEnvironment = true;
        } catch (NoSuchMethodException unused2) {
            unsupportedEnvironment = true;
        } catch (InvocationTargetException e) {
            exception = e.getCause();
            if (exception == null) {
                exception = e;
            }
        } catch (Throwable t) {
            exception = t;
        }
        if (unsupportedEnvironment) {
            throw new IllegalStateException("agent injection only works on a sun-derived 1.6 or higher VM");
        }
        if (exception != null) {
            throw new IllegalStateException("agent injection not supported on this platform due to unknown reason", exception);
        }
    }
}
