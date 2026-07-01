package com.discord.utilities.channel;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType, reason: use source file name */
/* JADX INFO: compiled from: GuildChannelIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildChannelIconUtils {

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Announcements */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Announcements extends GuildChannelIconUtils {
        public static final Announcements INSTANCE = new Announcements();

        private Announcements() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Directory */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Directory extends GuildChannelIconUtils {
        public static final Directory INSTANCE = new Directory();

        private Directory() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Forum */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Forum extends GuildChannelIconUtils {
        public static final Forum INSTANCE = new Forum();

        private Forum() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$ForumPost */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class ForumPost extends GuildChannelIconUtils {
        public static final ForumPost INSTANCE = new ForumPost();

        private ForumPost() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static abstract class Locked {

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Announcements */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Forum */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$ForumPost */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Text */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Locked$Thread */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        private Locked() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static abstract class NSFW {

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Announcements */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Announcements extends GuildChannelIconUtils {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Forum */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Forum extends GuildChannelIconUtils {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$ForumPost */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class ForumPost extends GuildChannelIconUtils {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Text */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Text extends GuildChannelIconUtils {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Thread */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Thread extends GuildChannelIconUtils {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$NSFW$Voice */
        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Voice extends GuildChannelIconUtils {
            public static final Voice INSTANCE = new Voice();

            private Voice() {
                super(null);
            }
        }

        private NSFW() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Text */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Text extends GuildChannelIconUtils {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Thread */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Thread extends GuildChannelIconUtils {
        public static final Thread INSTANCE = new Thread();

        private Thread() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelIconType$Voice */
    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Voice extends GuildChannelIconUtils {
        public static final Voice INSTANCE = new Voice();

        private Voice() {
            super(null);
        }
    }

    private GuildChannelIconUtils() {
    }

    public /* synthetic */ GuildChannelIconUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
