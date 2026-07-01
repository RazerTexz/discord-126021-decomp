package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ApplicationCommandData $applicationCommandData;
    public final /* synthetic */ Map $attachments;
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ boolean $autocomplete;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendCommand$commandResendCompressedHandler$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Attachment<?>>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list) {
            Object next;
            Intrinsics3.checkNotNullParameter(list, "compressedAttachments");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                Unit unit = Unit.a;
                Object arrayList = linkedHashMap.get(unit);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(unit, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : ChatInputViewModel$sendCommand$commandResendCompressedHandler$1.this.$attachments.entrySet()) {
                Object key = entry.getKey();
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    next = it.next();
                } while (!(((Attachment) next).getId() == ((Attachment) entry.getValue()).getId()));
                linkedHashMap2.put(key, next);
            }
            ChatInputViewModel$sendCommand$commandResendCompressedHandler$1 chatInputViewModel$sendCommand$commandResendCompressedHandler$1 = ChatInputViewModel$sendCommand$commandResendCompressedHandler$1.this;
            chatInputViewModel$sendCommand$commandResendCompressedHandler$1.this$0.sendCommand(chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$context, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$messageManager, chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$applicationCommandData, linkedHashMap2, (64 & 16) != 0 ? false : chatInputViewModel$sendCommand$commandResendCompressedHandler$1.$autocomplete, (64 & 32) != 0 ? false : true, (64 & 64) != 0 ? ChatInputViewModel.AnonymousClass1.INSTANCE : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendCommand$commandResendCompressedHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel.AttachmentContext attachmentContext, Map map, MessageManager messageManager, ApplicationCommandData applicationCommandData, boolean z2) {
        super(0);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$attachmentsContext = attachmentContext;
        this.$attachments = map;
        this.$messageManager = messageManager;
        this.$applicationCommandData = applicationCommandData;
        this.$autocomplete = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SendUtils.INSTANCE.compressImageAttachments(this.$context, this.$attachmentsContext.getAttachments(), new AnonymousClass1());
    }
}
