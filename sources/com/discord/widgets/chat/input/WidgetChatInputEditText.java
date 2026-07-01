package com.discord.widgets.chat.input;

import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText {
    public static final WidgetChatInputEditText$Companion Companion = new WidgetChatInputEditText$Companion(null);
    private long channelId;
    private final FlexEditText editText;
    private final Subject<Boolean, Boolean> emptyTextSubject;
    private long lastTypingEmissionMillis;
    private final MessageDraftsRepo messageDraftsRepo;
    private Function0<Unit> onSendListener;

    public WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo) {
        m.checkNotNullParameter(flexEditText, "editText");
        m.checkNotNullParameter(messageDraftsRepo, "messageDraftsRepo");
        this.editText = flexEditText;
        this.messageDraftsRepo = messageDraftsRepo;
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(Boolean.TRUE);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(true)");
        this.emptyTextSubject = behaviorSubjectL0;
        setOnTextChangedListener();
        setSoftwareKeyboardSendBehavior();
        setHardwareKeyboardSendBehavior();
    }

    public static final /* synthetic */ Subject access$getEmptyTextSubject$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.emptyTextSubject;
    }

    public static final /* synthetic */ long access$getLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText) {
        return widgetChatInputEditText.lastTypingEmissionMillis;
    }

    public static final /* synthetic */ void access$setLastTypingEmissionMillis$p(WidgetChatInputEditText widgetChatInputEditText, long j) {
        widgetChatInputEditText.lastTypingEmissionMillis = j;
    }

    private final void setHardwareKeyboardSendBehavior() {
        this.editText.setOnKeyListener(new WidgetChatInputEditText$setHardwareKeyboardSendBehavior$1(this));
    }

    private final void setOnTextChangedListener() {
        this.editText.addTextChangedListener(new WidgetChatInputEditText$setOnTextChangedListener$1(this));
    }

    private final void setSoftwareKeyboardSendBehavior() {
        this.editText.setOnEditorActionListener(new WidgetChatInputEditText$setSoftwareKeyboardSendBehavior$1(this));
    }

    public final void clearLastTypingEmission() {
        this.lastTypingEmissionMillis = 0L;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Function0<Unit> getOnSendListener() {
        return this.onSendListener;
    }

    public final String getText() {
        return Companion.toStringSafe(this.editText);
    }

    public final void saveText() {
        this.messageDraftsRepo.setTextChannelInput(this.channelId, this.editText.getText());
    }

    public final void setChannelId(long j) {
        this.channelId = j;
    }

    public final void setOnSendListener(Function0<Unit> function0) {
        this.onSendListener = function0;
    }

    public final void setChannelId(long channelId, boolean saveExistingText) {
        if (saveExistingText) {
            saveText();
        }
        this.channelId = channelId;
    }

    public /* synthetic */ WidgetChatInputEditText(FlexEditText flexEditText, MessageDraftsRepo messageDraftsRepo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flexEditText, (i & 2) != 0 ? MessageDraftsRepo$Provider.INSTANCE.get() : messageDraftsRepo);
    }
}
