document.addEventListener('DOMContentLoaded', () => {
  const greeting = document.getElementById('greeting');
  const hour = new Date().getHours();
  let text = 'Hello';
  if (hour < 12) text = 'Good morning';
  else if (hour < 18) text = 'Good afternoon';
  else text = 'Good evening';
  greeting.textContent = `${text}, welcome to my site!`;

  const toggle = document.getElementById('darkModeToggle');
  toggle.addEventListener('click', () => {
    document.documentElement.classList.toggle('dark');
  });
});
