function navigateTo(service) {
    alert(`Navigating to ${service} booking page...`);
    // You can replace this alert with a URL redirection, e.g.,
    // window.location.href = `/${service}-booking.html`;
  }
  document.addEventListener('DOMContentLoaded', () => {
    const scrollTopBtn = document.getElementById('scrollTopBtn');
  
    // Show scroll-to-top button on scroll
    window.addEventListener('scroll', () => {
      if (window.scrollY > 300) {
        scrollTopBtn.style.display = 'block';
      } else {
        scrollTopBtn.style.display = 'none';
      }
    });
  
    // Scroll to top when button is clicked
    scrollTopBtn.addEventListener('click', () => {
      window.scrollTo({ top: 0, behavior: 'smooth' });
    });
  
    // Fade-in effect for elements on scroll
    const fadeElements = document.querySelectorAll('[data-animate="fade-in"]');
  
    const fadeInOnScroll = () => {
      fadeElements.forEach(element => {
        const rect = element.getBoundingClientRect();
        const isInView = rect.top < window.innerHeight && rect.bottom > 0;
  
        if (isInView) {
          element.classList.add('in-view');
        }
      });
    };
  
    // Run fadeInOnScroll initially and on scroll
    fadeInOnScroll();
    window.addEventListener('scroll', fadeInOnScroll);
  });
    