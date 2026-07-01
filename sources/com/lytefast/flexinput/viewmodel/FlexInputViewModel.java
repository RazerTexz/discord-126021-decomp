package com.lytefast.flexinput.viewmodel;

import android.view.View;
import b.b.a.h.FlexInputEvent;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: FlexInputViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface FlexInputViewModel {
    boolean hasMediaPermissions();

    boolean hideExpressionTray();

    boolean isSingleSelectMode();

    Observable<FlexInputEvent> observeEvents();

    Observable<FlexInputState> observeState();

    void onAttachmentsUpdated(List<? extends Attachment<? extends Object>> attachments);

    void onContentDialogDismissed(boolean showKeyboard);

    void onContentDialogPageChanged(int index);

    void onCreateThreadSelected();

    void onExpandButtonClicked();

    void onExpressionTrayButtonClicked();

    void onFlexInputFragmentPause();

    void onGalleryButtonClicked();

    void onGiftButtonClicked();

    void onInputTextAppended(String appendText);

    void onInputTextChanged(String inputText, Boolean focused);

    boolean onInputTextClicked();

    void onSendButtonClicked(FlexInputListener inputListener);

    void onSingleAttachmentSelected(Attachment<? extends Object> attachment);

    boolean onToolTipButtonLongPressed(View button);

    void requestMediaPermissions(Function0<Unit> onSuccess);
}
