package com.azadxperias.ted.repository;

import com.azadxperias.ted.model.TedEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TedEventRepositoryIntegrationTest {

    @TestConfiguration
    static class TedApplicationTestContextConfiguration {

        @MockBean
        private JobLauncher mockedJobLauncher;

        @MockBean
        Job mockedJob;

        @MockBean
        JobExecution mockedJobExecution;

        @Bean
        public JobLauncher jobLauncher() {
            return mockedJobLauncher;
        }

        @Bean
        public Job job() {
            return mockedJob;
        }
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TedEventRepository tedEventRepository;

    @Test
    public void whenFindAll_thenReturnTedEvents() {
        TedEvent event = new TedEvent();
        event.setName("Ken Robinson: Do schools kill creativity?");
        event.setMainSpeaker("Ken Robinson");
        event.setDescription("Sir Ken Robinson makes an entertaining and profoundly moving case for creating an education system that nurtures (rather than undermines) creativity.");

        entityManager.persist(event);
        entityManager.flush();

        List<TedEvent> tedEvents = tedEventRepository.findAll();
        Assert.assertThat("number of tedEvents is not 1", tedEvents.size(), is(1));
    }

    @Test
    public void whenFindByEventName_thenReturnPaginatedTedEvents() {
        TedEvent event = new TedEvent();
        event.setName("Ken Robinson: Do schools kill creativity?");
        event.setMainSpeaker("Ken Robinson");
        event.setEvent("TED2006");
        event.setDescription("Sir Ken Robinson makes an entertaining and profoundly moving case for creating an education system that nurtures (rather than undermines) creativity.");

        entityManager.persist(event);
        entityManager.flush();

        event = new TedEvent();
        event.setName("David Pogue: Simplicity sells");
        event.setMainSpeaker("David Pogue");
        event.setEvent("TED2011");
        event.setDescription("New York Times columnist David Pogue takes aim at technologyäó»s worst interface-design offenders, and provides encouraging examples");

        entityManager.persist(event);
        entityManager.flush();

        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<TedEvent> tedEvents = tedEventRepository.findByEvent("TED2011", pageRequest);

        Assert.assertThat("number of tedEvents is not 1", tedEvents.getContent().size(), is(1));
        Assert.assertThat("incorrect ted talk name", tedEvents.getContent().get(0).getName(),
                is("David Pogue: Simplicity sells"));
    }
}
