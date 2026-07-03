package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.ApplicationCommandOption;
import com.lytefast.flexinput.model.Attachment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Event {

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class PickAttachment extends Event {
        private final ApplicationCommandOption commandOption;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PickAttachment(ApplicationCommandOption applicationCommandOption) {
            super(null);
            C12238m.checkNotNullParameter(applicationCommandOption, "commandOption");
            this.commandOption = applicationCommandOption;
        }

        public static /* synthetic */ PickAttachment copy$default(PickAttachment pickAttachment, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = pickAttachment.commandOption;
            }
            return pickAttachment.copy(applicationCommandOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public final PickAttachment copy(ApplicationCommandOption commandOption) {
            C12238m.checkNotNullParameter(commandOption, "commandOption");
            return new PickAttachment(commandOption);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PickAttachment) && C12238m.areEqual(this.commandOption, ((PickAttachment) other).commandOption);
            }
            return true;
        }

        public final ApplicationCommandOption getCommandOption() {
            return this.commandOption;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.commandOption;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PickAttachment(commandOption=");
            sbM833U.append(this.commandOption);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class PreviewAttachment extends Event {
        private final Attachment<?> attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewAttachment(Attachment<?> attachment) {
            super(null);
            C12238m.checkNotNullParameter(attachment, "attachment");
            this.attachment = attachment;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreviewAttachment copy$default(PreviewAttachment previewAttachment, Attachment attachment, int i, Object obj) {
            if ((i & 1) != 0) {
                attachment = previewAttachment.attachment;
            }
            return previewAttachment.copy(attachment);
        }

        public final Attachment<?> component1() {
            return this.attachment;
        }

        public final PreviewAttachment copy(Attachment<?> attachment) {
            C12238m.checkNotNullParameter(attachment, "attachment");
            return new PreviewAttachment(attachment);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PreviewAttachment) && C12238m.areEqual(this.attachment, ((PreviewAttachment) other).attachment);
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
            StringBuilder sbM833U = C1643a.m833U("PreviewAttachment(attachment=");
            sbM833U.append(this.attachment);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class RequestAutocompleteData extends Event {
        private final ApplicationCommandOption option;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestAutocompleteData(ApplicationCommandOption applicationCommandOption) {
            super(null);
            C12238m.checkNotNullParameter(applicationCommandOption, "option");
            this.option = applicationCommandOption;
        }

        public static /* synthetic */ RequestAutocompleteData copy$default(RequestAutocompleteData requestAutocompleteData, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommandOption = requestAutocompleteData.option;
            }
            return requestAutocompleteData.copy(applicationCommandOption);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public final RequestAutocompleteData copy(ApplicationCommandOption option) {
            C12238m.checkNotNullParameter(option, "option");
            return new RequestAutocompleteData(option);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof RequestAutocompleteData) && C12238m.areEqual(this.option, ((RequestAutocompleteData) other).option);
            }
            return true;
        }

        public final ApplicationCommandOption getOption() {
            return this.option;
        }

        public int hashCode() {
            ApplicationCommandOption applicationCommandOption = this.option;
            if (applicationCommandOption != null) {
                return applicationCommandOption.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RequestAutocompleteData(option=");
            sbM833U.append(this.option);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class ScrollAutocompletablesToApplication extends Event {
        private final long applicationId;
        private final int targetPosition;

        public ScrollAutocompletablesToApplication(long j, int i) {
            super(null);
            this.applicationId = j;
            this.targetPosition = i;
        }

        public static /* synthetic */ ScrollAutocompletablesToApplication copy$default(ScrollAutocompletablesToApplication scrollAutocompletablesToApplication, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = scrollAutocompletablesToApplication.applicationId;
            }
            if ((i2 & 2) != 0) {
                i = scrollAutocompletablesToApplication.targetPosition;
            }
            return scrollAutocompletablesToApplication.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public final ScrollAutocompletablesToApplication copy(long applicationId, int targetPosition) {
            return new ScrollAutocompletablesToApplication(applicationId, targetPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollAutocompletablesToApplication)) {
                return false;
            }
            ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (ScrollAutocompletablesToApplication) other;
            return this.applicationId == scrollAutocompletablesToApplication.applicationId && this.targetPosition == scrollAutocompletablesToApplication.targetPosition;
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final int getTargetPosition() {
            return this.targetPosition;
        }

        public int hashCode() {
            return (C0002b.m3a(this.applicationId) * 31) + this.targetPosition;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ScrollAutocompletablesToApplication(applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", targetPosition=");
            return C1643a.m814B(sbM833U, this.targetPosition, ")");
        }
    }

    private Event() {
    }

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
