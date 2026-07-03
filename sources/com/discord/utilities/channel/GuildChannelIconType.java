package com.discord.utilities.channel;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildChannelIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildChannelIconType {

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Announcements extends GuildChannelIconType {
        public static final Announcements INSTANCE = new Announcements();

        private Announcements() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Directory extends GuildChannelIconType {
        public static final Directory INSTANCE = new Directory();

        private Directory() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Forum extends GuildChannelIconType {
        public static final Forum INSTANCE = new Forum();

        private Forum() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class ForumPost extends GuildChannelIconType {
        public static final ForumPost INSTANCE = new ForumPost();

        private ForumPost() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static abstract class Locked {

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Announcements extends GuildChannelIconType {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Forum extends GuildChannelIconType {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class ForumPost extends GuildChannelIconType {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Text extends GuildChannelIconType {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Thread extends GuildChannelIconType {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        private Locked() {
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static abstract class NSFW {

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Announcements extends GuildChannelIconType {
            public static final Announcements INSTANCE = new Announcements();

            private Announcements() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Forum extends GuildChannelIconType {
            public static final Forum INSTANCE = new Forum();

            private Forum() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class ForumPost extends GuildChannelIconType {
            public static final ForumPost INSTANCE = new ForumPost();

            private ForumPost() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Text extends GuildChannelIconType {
            public static final Text INSTANCE = new Text();

            private Text() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Thread extends GuildChannelIconType {
            public static final Thread INSTANCE = new Thread();

            private Thread() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
        public static final class Voice extends GuildChannelIconType {
            public static final Voice INSTANCE = new Voice();

            private Voice() {
                super(null);
            }
        }

        private NSFW() {
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Text extends GuildChannelIconType {
        public static final Text INSTANCE = new Text();

        private Text() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Thread extends GuildChannelIconType {
        public static final Thread INSTANCE = new Thread();

        private Thread() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GuildChannelIconUtils.kt */
    public static final class Voice extends GuildChannelIconType {
        public static final Voice INSTANCE = new Voice();

        private Voice() {
            super(null);
        }
    }

    private GuildChannelIconType() {
    }

    public /* synthetic */ GuildChannelIconType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
