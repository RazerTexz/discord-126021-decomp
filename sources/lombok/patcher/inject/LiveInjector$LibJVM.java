package lombok.patcher.inject;

import com.sun.jna.Library;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/* JADX INFO: loaded from: app.apk:lombok/patcher/inject/LiveInjector$LibJVM.SCL.lombok */
public interface LiveInjector$LibJVM extends Library {
    int JNI_GetCreatedJavaVMs(PointerByReference pointerByReference, int i, IntByReference intByReference);
}
