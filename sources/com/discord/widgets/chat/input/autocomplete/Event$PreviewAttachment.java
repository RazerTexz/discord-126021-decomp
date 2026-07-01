package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Event$PreviewAttachment extends Event {
    private final Attachment<?> attachment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Event$PreviewAttachment(Attachment<?> attachment) {
        super(null);
        m.checkNotNullParameter(attachment, "attachment");
        this.attachment = attachment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Event$PreviewAttachment copy$default(Event$PreviewAttachment event$PreviewAttachment, Attachment attachment, int i, Object obj) {
        if ((i & 1) != 0) {
            attachment = event$PreviewAttachment.attachment;
        }
        return event$PreviewAttachment.copy(attachment);
    }

    public final Attachment<?> component1() {
        return this.attachment;
    }

    public final Event$PreviewAttachment copy(Attachment<?> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        return new Event$PreviewAttachment(attachment);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Event$PreviewAttachment) && m.areEqual(this.attachment, ((Event$PreviewAttachment) other).attachment);
        }
        return true;
    }

    public final Attachment<?> getAttachment() {
        return this.attachment;
    }

    public int hashCode() {
        Attachment<?> attachment = this.attachment;
        if (attachment != null) {
            return attachment.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PreviewAttachment(attachment=");
        sbU.append(this.attachment);
        sbU.append(")");
        return sbU.toString();
    }
}
