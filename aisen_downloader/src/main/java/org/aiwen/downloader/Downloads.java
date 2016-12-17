package org.aiwen.downloader;

import android.provider.BaseColumns;

/**
 * Created by 王dan on 2016/12/17.
 */

final class Downloads {

    public static final class Impl implements BaseColumns {

        private Impl() {}

        public static final String COLUMN_KEY = "key";

        /**
         * The name of the column where the initiating application can provided the
         * title of this download. The title will be displayed ito the user in the
         * list of downloads.
         * <P>Type: TEXT</P>
         * <P>Owner can Init/Read/Write</P>
         */
        public static final String COLUMN_TITLE = "title";

        /**
         * The name of the column where the initiating application can provide the
         * description of this download. The description will be displayed to the
         * user in the list of downloads.
         * <P>Type: TEXT</P>
         * <P>Owner can Init/Read/Write</P>
         */
        public static final String COLUMN_DESCRIPTION = "description";

        /**
         * The name of the column containing the URI of the data being downloaded.
         * <P>Type: TEXT</P>
         * <P>Owner can Init/Read</P>
         */
        public static final String COLUMN_URI = "uri";

        /**
         * The name of the column containing the filename where the downloaded data
         * was actually stored.
         * <P>Type: TEXT</P>
         * <P>Owner can Read</P>
         */
        public static final String _DATA = "_data";

        /**
         * The name of the column containing the current status of the download.
         * Applications can read this to follow the progress of each download. See
         * the STATUS_* constants for a list of legal values.
         * <P>Type: INTEGER</P>
         * <P>Owner can Read</P>
         */
        public static final String COLUMN_STATUS = "status";

        /**
         * The column with errorMsg for a failed downloaded.
         * Used only for debugging purposes.
         * <P>Type: TEXT</P>
         */
        public static final String COLUMN_ERROR_MSG = "errorMsg";

        /** The column that is used to count retries */
        public static final String COLUMN_FAILED_CONNECTIONS = "numfailed";

        /**
         * The name of the column containing the date at which some interesting
         * status changed in the download. Stored as a System.currentTimeMillis()
         * value.
         * <P>Type: BIGINT</P>
         * <P>Owner can Read</P>
         */
        public static final String COLUMN_LAST_MODIFICATION = "lastmod";

        /**
         * The name of the column containing the total size of the file being
         * downloaded.
         * <P>Type: INTEGER</P>
         * <P>Owner can Read</P>
         */
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";

        /**
         * The name of the column containing the size of the part of the file that
         * has been downloaded so far.
         * <P>Type: INTEGER</P>
         * <P>Owner can Read</P>
         */
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";

        /**
         * The name of the column holding a bitmask of allowed network types.  This is only used for
         * public API downloads.
         * <P>Type: INTEGER</P>
         * <P>Owner can Init/Read</P>
         */
        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";

        /**
         * If true, the user has confirmed that this download can proceed over the mobile network
         * even though it exceeds the recommended maximum size.
         * <P>Type: BOOLEAN</P>
         */
        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT = "bypass_recommended_size_limit";

    }

    public static final class Status {

        /**
         * This download hasn't stated yet
         */
        public static final int STATUS_PENDING = 190;

        /**
         * This download has started
         */
        public static final int STATUS_RUNNING = 192;

        /**
         * This download has been paused by the owning app.
         */
        public static final int STATUS_PAUSED_BY_APP = 193;

        /**
         * This download encountered some network error and is waiting before retrying the request.
         */
        public static final int STATUS_WAITING_TO_RETRY = 194;

        /**
         * This download is waiting for network connectivity to proceed.
         */
        public static final int STATUS_WAITING_FOR_NETWORK = 195;

        /**
         * This download exceeded a size limit for mobile networks and is waiting for a Wi-Fi
         * connection to proceed.
         */
        public static final int STATUS_QUEUED_FOR_WIFI = 196;

        /**
         * This download couldn't be completed due to insufficient storage
         * space.  Typically, this is because the SD card is full.
         */
        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;

        /**
         * This download has successfully completed.
         * Warning: there might be other status values that indicate success
         * in the future.
         * Use isSucccess() to capture the entire category.
         */
        public static final int STATUS_SUCCESS = 200;

    }

}