package lombok.patcher.inject;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/* JADX INFO: loaded from: app.apk:lombok/patcher/inject/LiveInjector$LibInstrument.SCL.lombok */
public interface LiveInjector$LibInstrument extends Library {
    void Agent_OnAttach(Pointer pointer, String str, Pointer pointer2);
}
