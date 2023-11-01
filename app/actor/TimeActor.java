package actor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.AbstractActorWithTimers;
import scala.concurrent.duration.Duration;

public class TimeActor extends AbstractActorWithTimers {

    private Set<ActorRef> userActors;
    private Set<ActorRef> profileActors;
    private Set<ActorRef> subredditActors;
    private Set<ActorRef> statsActors;

    private static final class Tick {
    }

    static public class RegisterMsg {
    }

    static public class RegisterMsg_pro {
    }
    static public class RegisterMsg_sub {
    }
    static public class RegisterMsg_stats {
    }

    /**
     * @author Kary Sutariya
     * @return TimeActor
     */
    static public Props getProps() {
        return Props.create(TimeActor.class, () -> new TimeActor());
    }

    private TimeActor(){
        this.userActors = new HashSet<>();
        this.profileActors = new HashSet<>();
        this.subredditActors  = new HashSet<>();
        this.statsActors  = new HashSet<>();
    }

    @Override
    public void preStart() {
        getTimers().startPeriodicTimer("Timer", new Tick(), Duration.create(1, TimeUnit.SECONDS));
    }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(RegisterMsg.class, msg -> userActors.add(sender()))
                .match(RegisterMsg_pro.class, msg -> profileActors.add(sender()))
                .match(RegisterMsg_sub.class, msg -> subredditActors.add(sender()))
                .match(RegisterMsg_stats.class,msg-> statsActors.add(sender()))
                .match(Tick.class, msg -> notifyClients())
//                .match(Tick_pro.class, msg -> notifyClients_pro())
                .build();
    }

    /**
     * @author Kary Sutariya
     * this function is sending message to all other actor at each 5 seconds.
     */
    private void notifyClients() {
        UserActor.TimeMessage tMsg = new UserActor.TimeMessage();
        userActors.forEach(ar -> ar.tell(tMsg, self()));
        ProfileActor.TimeMessage tMsg1 = new ProfileActor.TimeMessage();
        profileActors.forEach(ar -> ar.tell(tMsg1, self()));
        SubredditActor.TimeMessage tMsg2 = new SubredditActor.TimeMessage();
        subredditActors.forEach(ar -> ar.tell(tMsg2, self()));
        StatsActor.TimeMessage tMsg3 = new StatsActor.TimeMessage();
        statsActors.forEach(ar -> ar.tell(tMsg3,self()));
    }



}
