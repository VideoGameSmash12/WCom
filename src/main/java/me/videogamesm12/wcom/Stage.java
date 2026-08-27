package me.videogamesm12.wcom;

/**
 * Indicates the stage that a connection is at.
 */
public enum Stage
{
    /**
     * ERROR is typically used to indicate that an unrecoverable issue has occurred in the connection. Connections with
     *  this status should ignore any and all incoming packets.
     */
    ERROR,
    /**
     * HELLO is the first stage that every connection starts with. This is usually done during the initial steps of the
     *  handshake process of a connection.
     */
    HELLO,
    /**
     * CONFIGURATION is the second stage that starts after the HELLO stage is completed. This is where typically the
     *  client and server would negotiate settings and/or options.
     */
    CONFIGURATION,
    /**
     * READY is the third and final stage that starts after the CONFIGURATION stage is completed. This is where most
     *  packets would fall under.
     */
    READY,
    /**
     * ANY is a wildcard stage used in packet metadata to declare that the packet can be received at any stage.
     */
    ANY;

    /**
     * Checks if the given stage is compatible with this stage.
     * @param stage Stage
     * @return      True if the stages are equal or if we are the ANY stage wildcard.
     */
    public boolean isCompatible(Stage stage)
    {
        if (stage == ANY)
        {
            return true;
        }

        return stage.equals(this);
    }
}
