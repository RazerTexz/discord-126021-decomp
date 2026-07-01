package com.discord.chips_view;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.f.a;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: ChipsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipsView$c extends InputConnectionWrapper {
    public final /* synthetic */ ChipsView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView$c(ChipsView chipsView, InputConnection inputConnection) {
        super(inputConnection, true);
        this.a = chipsView;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        m.checkNotNullParameter(charSequence, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (this.a.mEditText.length() == 0 && i == 1 && i2 == 0) {
            return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
        }
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        m.checkNotNullParameter(keyEvent, "event");
        if (this.a.mEditText.length() != 0 || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
            return super.sendKeyEvent(keyEvent);
        }
        ChipsView chipsView = this.a;
        if (chipsView.mChipList.size() > 0) {
            try {
                Iterator it = chipsView.mChipList.entrySet().iterator();
                a<?, ?> aVar = null;
                while (it.hasNext()) {
                    aVar = (a) ((Map$Entry) it.next()).getValue();
                }
                if (aVar != null) {
                    m.checkNotNullParameter(aVar, "chip");
                    chipsView.f(aVar);
                    if (aVar.k) {
                        chipsView.e(aVar);
                    } else {
                        aVar.k = true;
                        chipsView.c(false);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                Log.e("ChipsView", "Out of bounds", e);
            }
        }
        return true;
    }
}
