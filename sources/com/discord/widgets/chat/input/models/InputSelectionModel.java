package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.input.models.MentionInputModel;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: InputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InputSelectionModel {
    private final MentionInputModel inputModel;
    private final Ranges2 selection;

    /* JADX INFO: compiled from: InputSelectionModel.kt */
    public static final /* data */ class CommandInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel.VerifiedCommandInputModel inputModel;
        private final ApplicationCommandOption selectedCommandOption;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommandInputSelectionModel(MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, Ranges2 ranges2, ApplicationCommandOption applicationCommandOption) {
            super(verifiedCommandInputModel, ranges2, null);
            Intrinsics3.checkNotNullParameter(verifiedCommandInputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.inputModel = verifiedCommandInputModel;
            this.selection = ranges2;
            this.selectedCommandOption = applicationCommandOption;
        }

        public static /* synthetic */ CommandInputSelectionModel copy$default(CommandInputSelectionModel commandInputSelectionModel, MentionInputModel.VerifiedCommandInputModel verifiedCommandInputModel, Ranges2 ranges2, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
            if ((i & 1) != 0) {
                verifiedCommandInputModel = commandInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                ranges2 = commandInputSelectionModel.getSelection();
            }
            if ((i & 4) != 0) {
                applicationCommandOption = commandInputSelectionModel.selectedCommandOption;
            }
            return commandInputSelectionModel.copy(verifiedCommandInputModel, ranges2, applicationCommandOption);
        }

        public final MentionInputModel.VerifiedCommandInputModel component1() {
            return getInputModel();
        }

        public final Ranges2 component2() {
            return getSelection();
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        public final CommandInputSelectionModel copy(MentionInputModel.VerifiedCommandInputModel inputModel, Ranges2 selection, ApplicationCommandOption selectedCommandOption) {
            Intrinsics3.checkNotNullParameter(inputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new CommandInputSelectionModel(inputModel, selection, selectedCommandOption);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommandInputSelectionModel)) {
                return false;
            }
            CommandInputSelectionModel commandInputSelectionModel = (CommandInputSelectionModel) other;
            return Intrinsics3.areEqual(getInputModel(), commandInputSelectionModel.getInputModel()) && Intrinsics3.areEqual(getSelection(), commandInputSelectionModel.getSelection()) && Intrinsics3.areEqual(this.selectedCommandOption, commandInputSelectionModel.selectedCommandOption);
        }

        public final ApplicationCommandOption getSelectedCommandOption() {
            return this.selectedCommandOption;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel.VerifiedCommandInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            Ranges2 selection = getSelection();
            int iHashCode2 = (iHashCode + (selection != null ? selection.hashCode() : 0)) * 31;
            ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
            return iHashCode2 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CommandInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(", selectedCommandOption=");
            sbU.append(this.selectedCommandOption);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel.VerifiedCommandInputModel getInputModel() {
            return this.inputModel;
        }
    }

    /* JADX INFO: compiled from: InputSelectionModel.kt */
    public static final /* data */ class MessageInputSelectionModel extends InputSelectionModel {
        private final MentionInputModel inputModel;
        private final Ranges2 selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageInputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2) {
            super(mentionInputModel, ranges2, null);
            Intrinsics3.checkNotNullParameter(mentionInputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(ranges2, "selection");
            this.inputModel = mentionInputModel;
            this.selection = ranges2;
        }

        public static /* synthetic */ MessageInputSelectionModel copy$default(MessageInputSelectionModel messageInputSelectionModel, MentionInputModel mentionInputModel, Ranges2 ranges2, int i, Object obj) {
            if ((i & 1) != 0) {
                mentionInputModel = messageInputSelectionModel.getInputModel();
            }
            if ((i & 2) != 0) {
                ranges2 = messageInputSelectionModel.getSelection();
            }
            return messageInputSelectionModel.copy(mentionInputModel, ranges2);
        }

        public final MentionInputModel component1() {
            return getInputModel();
        }

        public final Ranges2 component2() {
            return getSelection();
        }

        public final MessageInputSelectionModel copy(MentionInputModel inputModel, Ranges2 selection) {
            Intrinsics3.checkNotNullParameter(inputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(selection, "selection");
            return new MessageInputSelectionModel(inputModel, selection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageInputSelectionModel)) {
                return false;
            }
            MessageInputSelectionModel messageInputSelectionModel = (MessageInputSelectionModel) other;
            return Intrinsics3.areEqual(getInputModel(), messageInputSelectionModel.getInputModel()) && Intrinsics3.areEqual(getSelection(), messageInputSelectionModel.getSelection());
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public MentionInputModel getInputModel() {
            return this.inputModel;
        }

        @Override // com.discord.widgets.chat.input.models.InputSelectionModel
        public Ranges2 getSelection() {
            return this.selection;
        }

        public int hashCode() {
            MentionInputModel inputModel = getInputModel();
            int iHashCode = (inputModel != null ? inputModel.hashCode() : 0) * 31;
            Ranges2 selection = getSelection();
            return iHashCode + (selection != null ? selection.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessageInputSelectionModel(inputModel=");
            sbU.append(getInputModel());
            sbU.append(", selection=");
            sbU.append(getSelection());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private InputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2) {
        this.inputModel = mentionInputModel;
        this.selection = ranges2;
    }

    public MentionInputModel getInputModel() {
        return this.inputModel;
    }

    public Ranges2 getSelection() {
        return this.selection;
    }

    public /* synthetic */ InputSelectionModel(MentionInputModel mentionInputModel, Ranges2 ranges2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mentionInputModel, ranges2);
    }
}
