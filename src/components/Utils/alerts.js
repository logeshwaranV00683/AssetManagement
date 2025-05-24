import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

const MySwal = withReactContent(Swal);

export const showSuccessAlert = (title, text = '') => {
  MySwal.fire({
    title: <strong>{title}</strong>,
    html: text,
    icon: 'success',
    showClass: {
      popup: 'animate__animated animate__fadeInDownBig'
    },
    hideClass: {
      popup: 'animate__animated animate__fadeOutUpBig'
    }
  });
};

export const showErrorAlert = (title, text = '') => {
  MySwal.fire({
    title: <strong>{title}</strong>,
    html: text,
    icon: 'error',
    showClass: {
      popup: 'animate__animated animate__shakeX'
    },
    hideClass: {
      popup: 'animate__animated animate__zoomOut'
    }
  });
};

export const showConfirmAlert = async (title, text = '') => {
  const result = await MySwal.fire({
    title,
    html: text,
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: 'Yes',
    cancelButtonText: 'Cancel',
    reverseButtons: true,
    showClass: {
      popup: 'animate__animated animate__flipInY'
    },
    hideClass: {
      popup: 'animate__animated animate__flipOutY'
    }
  });

  return result.isConfirmed;
};
